package com.example.cursoandroidaula05.extensions

import android.content.Intent

import com.example.cursoandroidaula05.data.enums.MimeTypes

fun Intent?.isActionSend() = this?.action?.equals(Intent.ACTION_SEND) ?: false

fun Intent?.getStringExtraText() = this?.getStringExtra(Intent.EXTRA_TEXT).orEmpty()

fun Intent?.putStringExtraText(text: String?) = this?.putExtra(Intent.EXTRA_TEXT, text.orEmpty())

fun Intent?.isTextPlain() = this?.type?.equals(MimeTypes.TEXT_PLAIN.type) ?: false