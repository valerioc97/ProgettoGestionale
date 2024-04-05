package com.lavanderia.ProgettoGestionale.services;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import org.springframework.stereotype.Service;

@Service
public class PrinterService {

    // Metodo per stampare un documento
    public void print(String document) {
        // Trova la stampante predefinita
        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

        if (defaultPrintService == null) {
            System.err.println("Nessuna stampante disponibile.");
            return;
        }

        // Crea un job di stampa
        DocPrintJob printJob = defaultPrintService.createPrintJob();

        // Converti la stringa del documento in un array di byte
        byte[] bytes = document.getBytes();

        // Crea un documento semplice da stampare
        Doc doc = new SimpleDoc(bytes, DocFlavor.BYTE_ARRAY.AUTOSENSE, null);

        try {
            // Invia il documento alla stampante
            printJob.print(doc, null);
            System.out.println("Documento inviato alla stampante.");
        } catch (PrintException e) {
            System.err.println("Errore durante la stampa del documento: " + e.getMessage());
        }
    }
}
