package com.lavanderia.ProgettoGestionale.Controlles;

import com.lavanderia.ProgettoGestionale.services.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

@RestController
@RequestMapping("/lavanderia")
@CrossOrigin
public class StampaController {

    @Autowired
    private PrinterService printerService;

    //Soluzione on-premise.
    @GetMapping("/print")
    public ResponseEntity<String> stampaStringa(){
        String contentToPrint = "Contenuto da stampare";
        String messaggio;

        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable((graphics, pageFormat, pageIndex) -> {
            if(pageIndex == 0){
                graphics.drawString(contentToPrint, 100, 100);
                return Printable.PAGE_EXISTS;
            }else {
                return Printable.NO_SUCH_PAGE;
            }
        });

        try {
            job.print();
            messaggio = "Contenuto stampato";
        } catch (PrinterException e) {
            messaggio = "Contenuto non stampato";
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(messaggio);
    }

    //Soluzione cloud/remoto
    @GetMapping("/print1")
    public ResponseEntity<String> stampaStringa1(){
        String contentToPrint = "Contenuto da stampare";
        String messaggio;

        try {
            printerService.print(contentToPrint);
            messaggio = "Contenuto stampato";
        } catch (Exception e) {
            messaggio = "Contenuto non stampato";
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(messaggio);
    }
}
