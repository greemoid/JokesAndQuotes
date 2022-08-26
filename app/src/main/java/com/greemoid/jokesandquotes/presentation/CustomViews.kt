package com.greemoid.jokesandquotes.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ProgressBar
import com.greemoid.jokesandquotes.core.presentation.ShowImage
import com.greemoid.jokesandquotes.core.presentation.ShowText
import com.greemoid.jokesandquotes.core.presentation.ShowView

class CorrectImageButton : androidx.appcompat.widget.AppCompatImageView, ShowImage {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr)

    override fun show(id: Int) {
        setImageResource(id)
    }
}

class CorrectButton : androidx.appcompat.widget.AppCompatButton, ShowView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr)

    override fun show(arg: Boolean) {
        isEnabled = arg
    }
}

class CorrectProgress : ProgressBar, ShowView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr)

    override fun show(show: Boolean) {
        visibility = if (show) View.VISIBLE else View.INVISIBLE
    }
}

class CorrectTextView : androidx.appcompat.widget.AppCompatTextView, ShowText {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr)

    override fun show(text: String) {
        setText(text)
    }
}