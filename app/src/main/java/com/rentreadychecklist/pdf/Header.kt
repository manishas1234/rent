package com.rentreadychecklist.pdf

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import com.itextpdf.kernel.events.Event
import com.itextpdf.kernel.events.IEventHandler
import com.itextpdf.kernel.events.PdfDocumentEvent
import com.itextpdf.kernel.geom.Rectangle
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.canvas.PdfCanvas
import com.itextpdf.layout.Canvas
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Table



class Header(var doc: Document, val context: Context,val table: Table) : IEventHandler {

    private var tableHeight = 100f

    override fun handleEvent(event: Event) {
        val docEvent = event as PdfDocumentEvent
        val pdf: PdfDocument = docEvent.document
        val page = docEvent.page
        val pageSize: Rectangle = page.pageSize
        val pdfCanvas = PdfCanvas(
            page.lastContentStream, page.resources, pdf)
        val canvas = Canvas(pdfCanvas, pdf, pageSize)
        val rect = Rectangle(pdf.defaultPageSize.x + doc.leftMargin,
            pdf.defaultPageSize.top - doc.topMargin, 750f, 100f)
        Canvas(pdfCanvas, pdf, rect)
            .add(table)
        pdfCanvas.release();
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




