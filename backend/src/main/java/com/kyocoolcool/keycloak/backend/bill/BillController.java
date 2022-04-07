package com.kyocoolcool.keycloak.backend.bill;

import com.kyocoolcool.keycloak.backend.product.ProductRepository;
import com.kyocoolcool.keycloak.backend.util.Data;
import com.kyocoolcool.keycloak.backend.util.DataTransfer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("bills")
public class BillController {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    DataTransfer dataTransfer;

    @Autowired
    Data data;

    @GetMapping()
    public ResponseEntity<List<BillDTO>> getAllOrders() {
        List<Bill> bills = billRepository.findAllByDeletedIs(false);
        List<BillDTO> billDTOs = bills.stream().map(bill -> {
            BillDTO billDTO = new BillDTO();
            BeanUtils.copyProperties(bill, billDTO);
            billDTO.setProductName(dataTransfer.getData().get(bill.getProductId()));
            billDTO.setBuyer(data.getMembers().get(bill.getBuyer()).getName());
            billDTO.setGainer(data.getMembers().get(bill.getGainer()).getName());
            return billDTO;
        }).collect(Collectors.toList());
        return new ResponseEntity<List<BillDTO>>(billDTOs, HttpStatus.OK);
    }

    @PutMapping()
    public Bill saveOrder(@RequestBody Bill order) {
        return billRepository.save(order);
    }
}
