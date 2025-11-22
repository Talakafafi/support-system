package com.example.Support.System.controller;

import com.example.Support.System.entity.support.Status;
import com.example.Support.System.model.PageResponse;
import com.example.Support.System.model.SupportTicketModel;
import com.example.Support.System.service.SupportService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/support")
public class SupportController {

    final private SupportService supportService;

    public SupportController(final SupportService supportService) {
        this.supportService = supportService;
    }

    @PostMapping
    public ResponseEntity<SupportTicketModel> createTicket(@RequestBody final SupportTicketModel supportTicketModel) {
        return ResponseEntity.ok(supportService.createTicket(supportTicketModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupportTicketModel> getTicket(@PathVariable final String id) {
        return ResponseEntity.ok(supportService.getTicket(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupportTicketModel> updateTicket(@PathVariable final String id,
                                                           @RequestBody final SupportTicketModel supportTicketModel) {
        return ResponseEntity.ok(supportService.updateTicket(id, supportTicketModel));
    }

    @GetMapping("/all")
    public ResponseEntity<List<SupportTicketModel>> getAllTicket(@RequestParam final String name) {
        return ResponseEntity.ok(supportService.getAllTicketByConsumer(name));
    }

    @GetMapping("/consumer")
    public ResponseEntity<List<SupportTicketModel>> getAllTicketPages(@RequestParam final String name) {
        return ResponseEntity.ok(supportService.getAllTicketByConsumer(name));
    }

    @GetMapping
    public PageResponse<SupportTicketModel> getTickets(
            @RequestParam(required = false) Status status,
            @RequestParam(required = false) String consumerName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        PageRequest pageable = PageRequest.of(page, size);

        Page<SupportTicketModel> result =
                supportService.getTickets(consumerName, status, pageable);

        return PageResponse.of(result);
    }

}

