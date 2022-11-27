package com.rentreadychecklist.pdf

import PageXofY
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import androidx.core.app.ActivityCompat
import androidx.core.graphics.scale
import com.itextpdf.io.image.ImageDataFactory
import com.itextpdf.kernel.events.PdfDocumentEvent
import com.itextpdf.kernel.geom.PageSize
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.layout.Document
import com.itextpdf.layout.border.Border
import com.itextpdf.layout.element.Cell
import com.itextpdf.layout.element.Image
import com.itextpdf.layout.element.Paragraph
import com.itextpdf.layout.element.Table
import com.itextpdf.layout.property.TextAlignment
import com.rentreadychecklist.R
import com.rentreadychecklist.db.AppData
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

class PdfGenerator(applicationContext: Context)
{
    var context = applicationContext
    private lateinit var headerHandler: Header

    private lateinit var pageRotationEventHandler: PageRotationEventHandler


    fun pdfGenerator(list: List<AppData>) {
        val title = "RentReady.pdf"
        val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
        val file = File(path, title)
        if (!file.exists()) file.createNewFile()
        //PDF writer
        val pdfWriter = PdfWriter(FileOutputStream(file))
        val pdfDoc = com.itextpdf.kernel.pdf.PdfDocument(pdfWriter)
        val event = PageXofY(pdfDoc)
        pageRotationEventHandler = PageRotationEventHandler()

        val doc = Document(pdfDoc, PageSize.A4) //color set pending document
        doc.setMargins(120f, 36f, 36f, 36f)  //margin set

        // image for home image
        val homeImage = BitmapFactory.decodeResource(context.resources, R.drawable.nwhs_image)
        homeImage.scale(1, 1)
        val getBit = resizeBitmap(homeImage, 25, 20)
        val stream = ByteArrayOutputStream()
        getBit.compress(Bitmap.CompressFormat.PNG, 100, stream)
        val img: Image
        val byteArray: ByteArray = stream.toByteArray()
        val imgdata = ImageDataFactory.create(byteArray)
        img = Image(imgdata)

        //image for check image
        val checkImage = BitmapFactory.decodeResource(context.resources, R.drawable.check)
        checkImage.scale(1, 1)
        val setWidth = resizeBitmap(checkImage, 4, 7)
        val checkStream = ByteArrayOutputStream()
        setWidth.compress(Bitmap.CompressFormat.PNG, 100, checkStream)
        val byteArrayCheck: ByteArray = checkStream.toByteArray()
        val checkData = ImageDataFactory.create(byteArrayCheck)
        val checkImg = Image(checkData)

        // Set Header
        val size = floatArrayOf(100f, 300f, 350f)
        val table1 = Table(size)
        var rent = "Rent Ready Check List"
        var paragraph1 =
            Paragraph(rent).setBold().setTextAlignment(TextAlignment.CENTER).setFontSize(15f)
        var property = "Property Address____________________"
        var paragraph2 = Paragraph(property).setTextAlignment(TextAlignment.CENTER).setFontSize(10f)
        table1.addCell(Cell().add(Paragraph("Date: ________ \n PM: ________").setFontSize(10f))
            .setTextAlignment(
                TextAlignment.LEFT).setBorder(Border.NO_BORDER)).setFontSize(7f)
        table1.addCell(Cell().add(Cell().add(paragraph1).add(paragraph2)).setBorder(
            Border.NO_BORDER)).setBorder(Border.NO_BORDER)
        table1.addCell(Cell().add(img).setBorder(com.itextpdf.layout.border.Border.NO_BORDER))
            .setTextAlignment(
                TextAlignment.RIGHT)

        headerHandler = Header(doc, context, table1)
        pdfDoc.addEventHandler(PdfDocumentEvent.END_PAGE, event)
        pdfDoc.addEventHandler(PdfDocumentEvent.START_PAGE, headerHandler)
        pdfDoc.addEventHandler(PdfDocumentEvent.START_PAGE, pageRotationEventHandler)

// table add

        val takePicture = "Take Picture"
        val pictures =
            Paragraph(takePicture).setBold().setTextAlignment(TextAlignment.LEFT).setFontSize(10f)
                .setUnderline()
        pictures.marginTop = 20f

        /*  Table for address   */
        val column = floatArrayOf(20f, 200f)
        val addressTable = Table(column)
        addressTable.marginTop = 10f
        addressTable.setBorder(Border.NO_BORDER)
        addressTable.addCell(Cell().add(Cell().add(checkImg)).setBorder(Border.NO_BORDER))
        var addressColumn = "Address"
        val para1 = Paragraph(addressColumn).setTextAlignment(TextAlignment.LEFT).setFontSize(10f)
        addressTable.addCell(Cell().add(Cell().add(para1)).setBorder(Border.NO_BORDER))

        addressTable.addCell(Cell().add(Cell().add(checkImg)).setBorder(Border.NO_BORDER))
        var front = "Front Door Lock Set(3 Photos:Deadbolt,Handle,Full Set"
        val frontDoor = Paragraph(front).setTextAlignment(TextAlignment.LEFT).setFontSize(10f)
        addressTable.addCell(Cell().add(Cell().add(frontDoor)).setBorder(Border.NO_BORDER))

        addressTable.addCell(Cell().add(Cell().add(checkImg)).setBorder(Border.NO_BORDER))
        var Lock = "Lock Set From Garage To House Door (3 Photos: Deadbolt, Handle, Full Set"
        val lockSet = Paragraph(Lock).setTextAlignment(TextAlignment.LEFT).setFontSize(10f)
        addressTable.addCell(Cell().add(Cell().add(lockSet)).setBorder(Border.NO_BORDER))
        doc.add(addressTable)


        var outside = "Outside"
        val para =
            Paragraph(outside).setBold().setTextAlignment(TextAlignment.LEFT).setFontSize(10f)
                .setBold()
        para.marginTop = 10f
        doc.add(para)


        // table for
        val okWidth = 30f
        val naWidth = 30f
        val fixWidth = 30f
        val timeWidth = 70f
        val productWidth = 85f
        val notesWidth = 395f
        val columnWidth1 =
            floatArrayOf(okWidth, naWidth, fixWidth, timeWidth, productWidth, notesWidth)
        val table2 = Table(columnWidth1)


        table2.marginTop = 4f


        val tableHeader1 = arrayOf("OK", "NA", "Fix", "Time", "Product", "")
        for (i in 0 until tableHeader1.size) {
            table2.addCell(Cell().add(tableHeader1[i]).setBold())
        }

      for(i in 0 until list[0].outside?.size!!)
        {
            table2.addCell(Cell().add(list[0].outside[i].ok))
            table2.addCell(Cell().add(list[0].outside[i].na))
            table2.addCell(Cell().add(list[0].outside[i].fix.fix))
            table2.addCell(Cell().add(list[0].outside[i].fix.time))
            table2.addCell(Cell().add(list[0].outside[i].fix.product))
            val notes = list[0].outside[i].fix.notes
            val itemName = list[0].outside[i].items.ItemName
            table2.addCell(Cell().add("$itemName : $notes"))

        }
        doc.add(table2)

     /*   val fence = arrayOf("", "", "", "", "", "Fence: Notes Added")
        for (i in 0 until fence.size) {
            table2.addCell(Cell().add(fence[i]))
        }
        val gate = arrayOf("", "", "", "", "", "Gate: Notes Added")
        for (i in 0 until gate.size) {
            table2.addCell(Cell().add(gate[i]))
        }
        val porch = arrayOf("", "", "", "", "", "Porch/Coach Light:")
        for (i in 0 until porch.size) {
            table2.addCell(Cell().add(porch[i]))
        }
        val anti = arrayOf("", "", "", "", "", "Anti-Siphon Breaker Valve And Insulation:")
        for (i in 0 until anti.size) {
            table2.addCell(Cell().add(anti[i]))
        }
        val weatherproof =
            arrayOf("", "", "", "", "", "Weatherproof Receptacle Cover At Front Door: Notes Added")
        for (i in 0 until weatherproof.size) {
            table2.addCell(Cell().add(weatherproof[i]))
        }
        val stucco =
            arrayOf("", "", "", "", "", "Weatherproof Receptacle Cover At Front Door: Notes Added")
        for (i in 0 until stucco.size) {
            table2.addCell(Cell().add(stucco[i]))
        }
        val shutters = arrayOf("", "", "", "", "", "Shutters:")
        for (i in 0 until shutters.size) {
            table2.addCell(Cell().add(shutters[i]))
        }
        val satellite = arrayOf("", "", "", "", "", "Satellite Dish And Cables:  Story ")
        for (i in 0 until satellite.size) {
            table2.addCell(Cell().add(satellite[i]))
        }
        val address = arrayOf("", "", "", "", "", "Address Numbers Or Letters:")
        for (i in 0 until address.size) {
            table2.addCell(Cell().add(address[i]))
        }
        doc.add(table2)
        var text =
            "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                    "\n" +
                    "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham."
        var paragraph = Paragraph(text)
        doc.add(paragraph)

        var text1 =
            "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham."
        var para9 = Paragraph(text1)


        doc.add(para9)  */

        doc.close()
    }

    private fun resizeBitmap(bitmap: Bitmap, width: Int, height: Int): Bitmap {
        return Bitmap.createScaledBitmap(
            bitmap,
            convertDptoPixel(width),
            convertDptoPixel(height),
            false
        )
    }

    private fun convertDptoPixel(dp: Int): Int {
        return (dp * Resources.getSystem().displayMetrics.density).toInt()
    }

}

