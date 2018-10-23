package com.example.root.mvpdemo_kotlin.entity

/**
 *   author:Jiwenjie
 *   email:Jiwenjie97@gmail.com
 *   time:2018/10/20
 *   desc:
 *   version:1.0
 */
data class Book(var count: Int, var start: Int, var total: Int,
                var books: List<BooksBean>) {

    data class BooksBean(var rating: RatingBean, var subtitle: String,
                         var pubdate: String, var origin_title: String,
                         var image: String, var binding: String, var catalog: String,
                         var images: ImagesBean, var alt: String, var id: String,
                         var publisher: String, var isbn10: String, var isbn13: String,
                         var title: String, var url: String, var alt_title: String, var author_intro: String,
                         var summary: String, var price: String, var author: List<String>,
                         var tags: List<TagsBean>, var translator: List<String>) {

        data class RatingBean(var max: Int, var numRaters: Int,
                              var average: String, var min: Int)

        data class ImagesBean(var small: String, var large: String,
                              var medium: String)

        data class TagsBean(var count: Int, var name: String, var title: String)

    }

}