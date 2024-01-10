package com.samsung.IMS.service;

import com.samsung.IMS.db.entity.Item;
import com.samsung.IMS.db.repository.ItemRepository;
import com.samsung.IMS.model.IdVO;
import com.samsung.IMS.model.RequestDetailInfoVO;
import com.samsung.IMS.db.entity.Request;
import com.samsung.IMS.db.entity.RequestDetail;
import com.samsung.IMS.db.repository.RequestDetailRepository;
import com.samsung.IMS.db.repository.RequestRepository;
import com.samsung.IMS.model.constant.RequestDetailConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private RequestDetailRepository requestDetailRepository;

    public IdVO requestItem(RequestDetailInfoVO requestDetailInfoVO) throws Exception {

        Item item = itemRepository.findById(requestDetailInfoVO.getItemId()).orElse(null);

        if (item == null) {
            throw new Exception("item id doed not exist");
        }

        if (item.getStock() == 0) {
            throw new Exception("no items in stock");
        }

        /*
         * create request for user if not exists
         * then add request details in request
         */

        Request request = requestRepository.findByUserId(requestDetailInfoVO.getUserId());

        if (request == null) {
            request = Request.builder()
                    .userId(requestDetailInfoVO.getUserId())
                    .build();
            request = requestRepository.save(request);
        }

        RequestDetail requestDetail = RequestDetail.builder()
                .quantity(1)
                .requestId(request.getRequestId())
                .itemId(requestDetailInfoVO.getItemId())
                .requestStartDate(requestDetailInfoVO.getStartDate())
                .requestEndDate(requestDetailInfoVO.getEndDate())
                .reason(requestDetailInfoVO.getReason())
                .status(RequestDetailConstant.REQUEST_DETAIL_PENDING)
                .build();

        requestDetailRepository.save(requestDetail);

        return IdVO.builder()
                .id(requestDetail.getRequestDetailId())
                .build();

    }
}
