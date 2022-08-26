package com.greemoid.jokesandquotes.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CheckBox
import android.widget.LinearLayout
import com.greemoid.jokesandquotes.R
import com.greemoid.jokesandquotes.core.presentation.CommonViewModel

class FavoriteDataView : LinearLayout {

    private lateinit var button: CorrectButton
    private lateinit var textView: CorrectTextView
    private lateinit var progressBar: CorrectProgress
    private lateinit var btnChange: CorrectImageButton
    private lateinit var checkBox: CheckBox


    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr) {
        init(attrs)
    }


    private fun init(attrs: AttributeSet) {
        orientation = VERTICAL
        (context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(R.layout.favorite_data_view, this, true)
        checkBox = getChildAt(0) as CheckBox
        val linear = getChildAt(1) as LinearLayout
        textView = linear.findViewById(R.id.textView)
        btnChange = linear.findViewById(R.id.changeButton)
        progressBar = getChildAt(2) as CorrectProgress
        button = getChildAt(3) as CorrectButton

        context.theme.obtainStyledAttributes(attrs, R.styleable.FavoriteDataView, 0, 0).apply {
            try {
                val actionButtonText = getString(R.styleable.FavoriteDataView_actionButtonText)
                val checkBoxText = getString(R.styleable.FavoriteDataView_checkBoxText)
                checkBox.text = checkBoxText
                button.text = actionButtonText
            } finally {
                recycle()
            }
        }
    }


    fun listenChanges(block: (checked: Boolean) -> Unit) =
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            block.invoke(isChecked)
        }

    fun handleChangeButton(block: () -> Unit) = btnChange.setOnClickListener {
        block.invoke()
    }

    fun handleActionButton(block: () -> Unit) = button.setOnClickListener {
        block.invoke()
    }

    fun linkWith(commonViewModel: CommonViewModel) {
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            commonViewModel.chooseFavorite(isChecked)
        }
        btnChange.setOnClickListener {
            commonViewModel.changeItemStatus()
        }
        button.setOnClickListener {
            commonViewModel.getItem()
        }
    }

    fun show(state: State) = state.show(progressBar, button, textView, btnChange)
}