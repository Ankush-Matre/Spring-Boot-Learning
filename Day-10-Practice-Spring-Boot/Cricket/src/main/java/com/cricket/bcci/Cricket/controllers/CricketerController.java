package com.cricket.bcci.Cricket.controllers;

import com.cricket.bcci.Cricket.dtos.CricketerDTO;
import com.cricket.bcci.Cricket.services.CricketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/cricketers")
public class CricketerController {

    private final CricketService cricketService;

    public CricketerController(CricketService cricketService) {
        this.cricketService = cricketService;
    }

    @GetMapping(path = "/{cricketerId}")
    public ResponseEntity<CricketerDTO> getCricketerById(@PathVariable(name = "cricketerId") Integer id){
        Optional<CricketerDTO> cricketerDTO = cricketService.getCricketerById(id);
        return cricketerDTO
                .map(cricketerDTO1 -> ResponseEntity.ok(cricketerDTO1))
                .orElse(null);
    }

    @GetMapping()
    public ResponseEntity<List<CricketerDTO>> getAllCricketers(@RequestParam (required = false , name = "inputAge") Integer age){
        return ResponseEntity.ok(cricketService.getAllCricketers());
    }

    @PostMapping
    public ResponseEntity<CricketerDTO> createNewEmployee(@RequestBody CricketerDTO newCricketer){
        CricketerDTO cricketerDTO = cricketService.createNewEmployee(newCricketer);
        return new ResponseEntity<>(cricketerDTO , HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{cricketerId}")
    public ResponseEntity<Boolean> deleteCricketerById(@PathVariable Integer cricketerId){
        boolean gotDelete = cricketService.deleteCricketerById(cricketerId);
        if(gotDelete){
            return ResponseEntity.ok(true);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}
