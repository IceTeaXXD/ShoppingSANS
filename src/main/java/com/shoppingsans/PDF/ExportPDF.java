/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.PDF;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.shoppingsans.Datastore.DataStore;
import com.shoppingsans.JualBarang.Barang;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

/**
 *
 * @author Matthew
 */
public class ExportPDF {
    public static final Font judul = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    
    public static final Font text = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
    
    public static void addLine(Paragraph d, int n){
        for(int i = 0; i < n ; i++){
            d.add(new Paragraph(" "));
        }
    }
    
    public static void createHistoryTransaksi(DataStore ds, String folder) throws FileNotFoundException, DocumentException{
        Document document = new Document();
        document.setPageSize(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream(folder + "Riwayat Transaksi.pdf"));
        
        document.open();
        /* Meta Data */
        document.addAuthor("ShoppingSans");
        document.addTitle("Riwayat Transaksi");
        document.addCreationDate();
        
        /* Isi */
        Paragraph title = new Paragraph();
        
        title.add(new Paragraph("Riwayat Transaksi", judul));
        title.add(new Paragraph("Dikeluarkan pada: " + new Date(), text));
        addLine(title, 2);
        
        document.add(title);
        document.close();
    }

    public static void createLaporanBarang(DataStore ds, String folder) throws FileNotFoundException, DocumentException{
        Document document = new Document();
        document.setPageSize(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream(folder + "Laporan Inventory Barang.pdf"));
        
        document.open();
        /* Meta Data */
        document.addAuthor("ShoppingSans");
        document.addTitle("Laporan Inventory Barang");
        document.addCreationDate();
        /* Isi */
        Paragraph title = new Paragraph();
        
        title.add(new Paragraph("Laporan Inventory Barang", judul));
        title.add(new Paragraph("Dikeluarkan pada: " + new Date(), text));
        addLine(title, 2);
        
        document.add(title);
       
        
        PdfPTable tabel = new PdfPTable(6);
        
        /* Make the headers */
        
        PdfPCell header = new PdfPCell(new Phrase("ID Barang"));
        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabel.addCell(header);
        
        header = new PdfPCell(new Phrase("Nama Barang"));
        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabel.addCell(header);
        
        header = new PdfPCell(new Phrase("Harga Barang"));
        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabel.addCell(header);
        
        header = new PdfPCell(new Phrase("Stok Barang"));
        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabel.addCell(header);
        
        header = new PdfPCell(new Phrase("Harga Beli Barang"));
        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabel.addCell(header);
        
        header = new PdfPCell(new Phrase("Kategori Barang"));
        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabel.addCell(header);
        tabel.setHeaderRows(1);
       
                
        /* Fill in the table */
        for(Barang b : ds.getInventoryBarang().getInventory()){
            tabel.addCell(Integer.toString(b.getIdBarang()));
            tabel.addCell(b.getNamaBarang());
            tabel.addCell(String.valueOf(b.getHargaBarang()));
            tabel.addCell(String.valueOf(b.getStokBarang()));
            tabel.addCell(String.valueOf(b.getHargaBeli()));
            tabel.addCell(b.getKategori());
        }
        document.add(tabel);
        document.close();
        
    }
}
