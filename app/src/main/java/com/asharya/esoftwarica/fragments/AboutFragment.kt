package com.asharya.esoftwarica.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.asharya.esoftwarica.R

class AboutFragment : Fragment() {
    private lateinit var wvSoftwarica : WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        wvSoftwarica = view.findViewById(R.id.wvSoftwarica)
        wvSoftwarica.webViewClient = WebViewClient()
        wvSoftwarica.loadUrl("https://softwarica.edu.np")

        return view
    }
}