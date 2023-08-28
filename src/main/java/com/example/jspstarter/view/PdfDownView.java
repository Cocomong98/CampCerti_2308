package com.example.jspstarter.view;

import java.util.List;
import java.util.Map;

import com.example.jspstarter.Vo.CampVo;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PdfDownView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(
            Map<String, Object> model,
            Document doc,
            PdfWriter writer,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        CampVo user = (CampVo) model.get("user");
        List<String> list = (List<String>)model.get("list");


        BaseFont bfKorea = BaseFont.createFont("/Users/cocomong_98/IdeaProjects/CampCerti_2308/src/main/webapp/static/font/ChosunCentennial_ttf.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font = new Font(bfKorea, 20);
        Font head = new Font(bfKorea, 40);
        Font data = new Font(bfKorea, 15);

        PdfContentByte canvas = writer.getDirectContentUnder();
        Image backgroundImage = Image.getInstance("/Users/cocomong_98/IdeaProjects/CampCerti_2308/src/main/webapp/static/image/border.png"); // 배경 이미지 경로

        // 배경이미지 너비설정
        float desiredWidth = doc.getPageSize().getWidth();
        float desiredHeight = doc.getPageSize().getHeight();
        backgroundImage.scaleAbsolute(desiredWidth, desiredHeight);

        backgroundImage.setAbsolutePosition(0, 0);
        canvas.addImage(backgroundImage);

        // 여기까지는 배경설정

        // 거리를 두기 위해서 공백을 출력
        Paragraph emptySpace1 = new Paragraph("\n"); // 빈 줄 추가
        emptySpace1.setSpacingAfter(100); // 여백길이는 80
        doc.add(emptySpace1);

        doc.setMargins(0, 0, 70, 70);
        Paragraph title = new Paragraph("수료증", head);
        title.setSpacingAfter(30);
        title.setAlignment(Element.ALIGN_CENTER);
        doc.add(title);

        // Set up content for the first column (left top)
        Paragraph firstColumn = new Paragraph();
        firstColumn.setAlignment(Element.ALIGN_CENTER);
        firstColumn.setFont(font);

        // Set up content for the second column (right top)
        Paragraph secondColumn = new Paragraph();
        secondColumn.setAlignment(Element.ALIGN_LEFT);
        secondColumn.setFont(data);

        secondColumn.add("캠프명 : " + user.getCamp());
        secondColumn.add(" " + "\n\n");
        secondColumn.add("캠프기간 : " +user.getP_start() + " ~ " + user.getP_end());
        secondColumn.add(" " + "\n\n");
        secondColumn.add("전공 : " + user.getMajor() + "\n");
        secondColumn.add(" " + "\n");
        secondColumn.add("이름 : " + user.getName());

        // Create a table with two columns
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);

        // Add cells to the table
        PdfPCell firstCell = new PdfPCell(firstColumn);
        firstCell.setBorder(Rectangle.NO_BORDER);
        firstCell.setHorizontalAlignment(Element.ALIGN_CENTER); // Center content in cell
        firstCell.setPaddingTop(50);
        table.addCell(firstCell);

        PdfPCell secondCell = new PdfPCell(secondColumn);
        secondCell.setBorder(Rectangle.NO_BORDER);
        secondCell.setHorizontalAlignment(Element.ALIGN_CENTER); // Center content in cell
        secondCell.setPaddingTop(50);
        table.addCell(secondCell);

        // Add the table to the document
        doc.add(table);

        // 거리를 두기 위해서 공백을 출력
        Paragraph emptySpace2 = new Paragraph("\n"); // 빈 줄 추가
        emptySpace2.setSpacingBefore(80); // 여백길이는 80
        doc.add(emptySpace2);

        Paragraph userData = new Paragraph("위 학생은 <" + user.getCamp() + "> 과정을 수료하였음을 인증함\n\n\n한동대학교",font);
        userData.setAlignment(Element.ALIGN_CENTER);
        userData.setSpacingBefore(10);
        doc.add(userData);

        doc.close(); // Close the document
    }
}
