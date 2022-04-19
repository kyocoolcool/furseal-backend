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
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("bills")
public class BillController {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    DataTransfer dataTransfer;

    @Autowired
    Data data;

    @GetMapping()
    public ResponseEntity<List<BillDTO>> getAllBills() {
        List<Bill> bills = billRepository.findAllByDeletedIs(false);

        List<BillDTO> billDTOs = bills.stream().map(bill -> {
            BillDTO billDTO = new BillDTO();
            BeanUtils.copyProperties(bill, billDTO);
            billDTO.setProductName(bill.getProduct().getName());
            billDTO.setBuyer(data.getMembers().get(bill.getBuyer()).getName());
            billDTO.setGainer(data.getMembers().get(bill.getGainer()).getName());
            billDTO.setMemberCount(bill.getMembers().size());
            return billDTO;
        }).collect(Collectors.toList());
        return new ResponseEntity<List<BillDTO>>(billDTOs, HttpStatus.OK);
    }

    @GetMapping("{billId}")
    public ResponseEntity getBill(@PathVariable Long billId) {
        Optional<Bill> billOptional = billRepository.findById(billId);
        BillDTO billDTO = new BillDTO();
        billOptional.ifPresent(bill->{
            BeanUtils.copyProperties(bill, billDTO);
            billDTO.setProductName(bill.getProduct().getName());
            billDTO.setBuyer(data.getMembers().get(bill.getBuyer()).getName());
            billDTO.setGainer(data.getMembers().get(bill.getGainer()).getName());
            billDTO.setMemberCount(bill.getMembers().size());
        });
        return new ResponseEntity<BillDTO>(billDTO, HttpStatus.OK);
    }

    @PutMapping("{billId}")
    public Bill updateBill(@RequestBody BillDTO billDTO) {
        log.info("updateBill");
        log.info(billDTO.toString());
        Bill bill = new Bill();
        BeanUtils.copyProperties(billDTO, bill);
        bill.setBuyer(data.getMembersByString().get(billDTO.getBuyer()).getMemberId());
        bill.setGainer(data.getMembersByString().get(billDTO.getGainer()).getMemberId());
        bill.setProduct(data.getProductsByString().get(billDTO.getProductName()));
        log.info(bill.toString());
        return billRepository.save(bill);
    }

    @DeleteMapping("{billId}")
    public Bill deleteBill(@PathVariable Long billId) {
        Optional<Bill> optionalBill = billRepository.findById(billId);
        Bill bill = optionalBill.get();
        bill.setDeleted(true);
        return  billRepository.save(bill);
    }
}
