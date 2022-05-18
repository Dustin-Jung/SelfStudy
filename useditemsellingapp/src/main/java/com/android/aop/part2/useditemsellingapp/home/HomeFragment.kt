package com.android.aop.part2.useditemsellingapp.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.aop.part2.useditemsellingapp.R
import com.android.aop.part2.useditemsellingapp.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class HomeFragment: Fragment(R.layout.fragment_home) {

    private lateinit var userDB: DatabaseReference
    private lateinit var articeDB: DatabaseReference
    private lateinit var articleRecyclerViewAdapter : ArticleRecyclerViewAdapter

    private val articleList = mutableListOf<ArticleModel>()
    private val listener = object :ChildEventListener{
        override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {

            val articleModel = snapshot.getValue(ArticleModel::class.java)
            articleModel ?: return

            articleList.add(articleModel)
            articleRecyclerViewAdapter.submitList(articleList)

        }

        override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {

        }

        override fun onChildRemoved(snapshot: DataSnapshot) {

        }

        override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {

        }

        override fun onCancelled(error: DatabaseError) {

        }

    }

    private var binding : FragmentHomeBinding? = null
    private val auth: FirebaseAuth by lazy {
        Firebase.auth
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val fragmentHomeBinding = FragmentHomeBinding.bind(view)
        binding = fragmentHomeBinding

        articleList.clear()

        articeDB = Firebase.database.reference.child("Articles")

        articleRecyclerViewAdapter = ArticleRecyclerViewAdapter()


        fragmentHomeBinding.articleRecyclerView.layoutManager = LinearLayoutManager(context)
        fragmentHomeBinding.articleRecyclerView.adapter = ArticleRecyclerViewAdapter()

        fragmentHomeBinding.addFloatingButton.setOnClickListener {
            context?.let {
                if(auth.currentUser != null){
                    val intent = Intent(it, AddArticleActivity::class.java)
                    startActivity(intent)
                } else{
                    Snackbar.make(view,"로그인 후 사용해주세요", Snackbar.LENGTH_LONG).show()
                }
            }
        }

        articeDB.addChildEventListener(listener)

    }

    override fun onResume() {
        super.onResume()

        articleRecyclerViewAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        articeDB.removeEventListener(listener)
    }
}