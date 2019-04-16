package test;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class itextTest {


    public static void main(String[] args) throws IOException, DocumentException {
        //字体设置
        BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        BaseFont BLACK = BaseFont.createFont("/SIMHEI.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        BaseFont SONG = BaseFont.createFont("/SIMSUN.TTC,1", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font title = new Font(BLACK, 36, Font.BOLD, BaseColor.RED);//创建全文标题字体，参数分别是字体类别,字号,效果
        Font subtitle = new Font(SONG, 14, Font.BOLD);//创建全文标题字体，参数分别是字体类别,字号,效果
        Font content = new Font(baseFont, 12, Font.NORMAL);//创建全文标题字体，参数分别是字体类别,字号,效果
        Paragraph paragraphTitle = new Paragraph("标题测试", title);//设置文本内容和要使用的字体
        Paragraph paragraphSubTitle = new Paragraph("小标题", subtitle);//设置文本内容和要使用的字体
        Paragraph paragraphCount = new Paragraph("作为预备党员的这一年，我的人生实现了巨大的飞跃。一年来，我按照党章的规定严格要求自己，特别成为班干部之后，以保持党员先进性教育活动为契机，我在思想政治素质、政治理论水平和实际工作能力等各方面有了较大的进步。按照党章的有关规定，我的预备期已满一年，现申请转为正式党员。为了便于党组织对我的考察，现将自己一年来的情况向党组织汇报如下：中国共 产党是中国工人阶级的先锋队，是中国各族人民利益的忠实代表，是中国社会主义事业的领导核心。党的这一性质，决定了它的每个成员应当具有崇高的理想追求，坚定的政治信念，先进的思想觉悟，坚强的组织观念，必备的科学文化知识和高尚的道德情操，应该成为社会的中坚，民族的脊梁，阶级的先锋和时代的楷模。这就要求每一个共产党员要努力在政治、思想、道德品质和知识技能方面，按照党性原则进行自我教育、自我锻炼、自我改造和自我完善。 来源无忧考网：https://www.51test.net 原文网址：https://www.51test.net/show/9276121.html", content);
        paragraphTitle.setAlignment(Element.ALIGN_CENTER);//
        //paragraphCount.setLeading(50);
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/D:/SetAttributeExample.pdf"));
        document.open();
        document.setPageSize(PageSize.A4);
        document.setMargins(30, 30, 50, 30);
        document.add(paragraphTitle);
        LineSeparator line = new LineSeparator(2, 100, BaseColor.RED, Element.ALIGN_CENTER, -2);
        Paragraph p_line = new Paragraph("分割线");
        p_line.setSpacingAfter(10);
        p_line.setSpacingBefore(10);
        p_line.add(line);
        document.add(p_line);
        document.add(paragraphSubTitle);
        document.add(paragraphCount);
        document.add(paragraphSubTitle);
        document.add(paragraphCount);
        document.add(paragraphSubTitle);
        document.add(paragraphCount);
        document.add(paragraphSubTitle);
        document.add(paragraphCount);
        //Set attributes here
        document.addAuthor("我是作者");
        document.addCreationDate();
        document.addCreator("我是应用程序");
        document.addTitle("我是标题");
        document.addSubject("我是主题");
        document.close();
        writer.close();

        Long l = 110l;
        Float f = Float.valueOf(l / 10);
        System.out.println(new Date().toString());
    }
}
