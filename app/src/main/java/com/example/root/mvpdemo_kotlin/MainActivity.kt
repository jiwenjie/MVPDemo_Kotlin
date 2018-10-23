package com.example.root.mvpdemo_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.root.mvpdemo_kotlin.contract.BookContract
import com.example.root.mvpdemo_kotlin.entity.Book
import com.example.root.mvpdemo_kotlin.presenter.BooksPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BookContract.BookView {

    var presenter: BooksPresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = BooksPresenter(applicationContext)
        presenter!!.attachView(mBookView)
        initView()
    }

    private val mBookView = object : BookContract.BookView {
        override fun setData(beans: Book) {

            Toast.makeText(applicationContext, "获取的值是：" + beans.toString(), Toast.LENGTH_SHORT).show()
            content.setText(beans.toString())
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    fun initView() {
        Test.setOnClickListener {
            presenter!!.requestData()

        }
    }

    override fun setData(beans: Book) {
        Toast.makeText(applicationContext, "获取的值是：" + beans.toString(), Toast.LENGTH_SHORT).show()
        content.setText(beans.toString())
    }
}
