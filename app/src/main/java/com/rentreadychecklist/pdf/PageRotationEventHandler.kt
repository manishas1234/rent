package com.rentreadychecklist.pdf

import com.itextpdf.kernel.events.Event
import com.itextpdf.kernel.events.IEventHandler
import com.itextpdf.kernel.events.PdfDocumentEvent
import com.itextpdf.kernel.pdf.PdfName
import com.itextpdf.kernel.pdf.PdfNumber


class PageRotationEventHandler : IEventHandler {
    private val portrait = PdfNumber(0)

    var rotation: PdfNumber = portrait
    @JvmName("setRotation1")
    fun setRotation(orientation: PdfNumber) {
        rotation = orientation
    }

    override fun handleEvent(event: Event) {
        val docEvent = event as PdfDocumentEvent
        docEvent.page.put(PdfName.Rotate, rotation)
    }
}