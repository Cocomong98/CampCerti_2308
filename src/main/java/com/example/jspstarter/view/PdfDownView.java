package com.example.jspstarter.view;

import java.util.List;
import java.util.Map;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
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

        List<String> list = (List<String>)model.get("list");

        // 기본 폰트 설정 - 폰트에 따라 한글 출력 여부가 결정됩니다.
        BaseFont bfKorea = BaseFont.createFont("/Users/cocomong_98/IdeaProjects/CampCerti_2308/src/main/webapp/static/font/ChosunCentennial_ttf.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font = new Font(bfKorea);

        PdfContentByte canvas = writer.getDirectContentUnder();
        Image backgroundImage = Image.getInstance("/Users/cocomong_98/IdeaProjects/CampCerti_2308/src/main/webapp/static/image/border.png"); // 배경 이미지 경로

        backgroundImage.scaleAbsolute(doc.getPageSize().getWidth(), doc.getPageSize().getHeight());

        backgroundImage.setAbsolutePosition(0, 0);
        canvas.addImage(backgroundImage);

        Paragraph title = new Paragraph("캠프 수료 증명서 발급", font);
        title.setAlignment(Element.ALIGN_CENTER);
        doc.add(title);

        // 데이터를 테이블에 추가
        Table table = new Table(1, list.size());
        table.setPadding(5);

        for (String language : list) {
            Cell cell = new Cell(new Paragraph(language, font));
            table.addCell(cell);
        }

        // 테이블 문서에 추가
        doc.add(table);
    }
}
