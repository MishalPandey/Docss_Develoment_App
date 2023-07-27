package com.mishalpandey.docss.development

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.fitnytech.influencerApp.development.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class MainActivity : AppCompatActivity() {
    var PICK_IMAGE =1
    var ImageList = ArrayList<Uri>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val logOut = findViewById<Button>(R.id.logOut)

        logOut.setOnClickListener {
                //User wants to Logout
                val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(getString(R.string.default_web_client_id))
                    .requestEmail()
                    .build()
                val googlesigninclient = GoogleSignIn.getClient(this,gso)
                googlesigninclient.signOut()
                startActivity(Intent(this , LoginActivity::class.java))

        }

        val createPost = findViewById<FloatingActionButton>(R.id.createPost)

        createPost.setOnClickListener {
            Toast.makeText(this, "right", Toast.LENGTH_SHORT).show()
            val intent : Intent = Intent(this , Img_Vid_View::class.java)
            startActivity(intent)
            // adding images and videos to firebase

                //var intent = Intent(Intent.ACTION_GET_CONTENT)
//                val intent = Intent(Intent.ACTION_PICK)
//                intent.type = "image/* video/*"
//                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
//                startActivityForResult(intent, PICK_IMAGE)
//                startActivityForResult(Intent.createChooser(intent, "Select Images"), PICK_IMAGE)
//            val intent = Intent(Intent.ACTION_GET_CONTENT)
//            intent.addCategory(Intent.CATEGORY_OPENABLE)
//            intent.type = "image/* video/*"
//            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
//            intent.putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("image/*", "video/*"))
//            startActivityForResult(intent, PICK_IMAGE)
            }
        }

//        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//            super.onActivityResult(requestCode, resultCode, data)
//
//            if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
//                if (data?.clipData != null) {
//                    val count = data.clipData!!.itemCount
//                    for (i in 0 until count) {
//                        val imageUri = data.clipData!!.getItemAt(i).uri
//                        ImageList.add(imageUri)
//                    }
//                } else if (data?.data != null) {
//                    val imageUri = data.data
//                    ImageList.add(imageUri!!)
//                }
//            }
//            uploadImg(ImageList)
//
//        }

//    private fun uploadImg(imgUriList: ArrayList<Uri>) {
//        // for uploading images and videos to firebase
//        for (imgUri in imgUriList) {
//            var uuid = UUID.randomUUID().toString()
//
//            if (imgUri.toString().contains("video") || imgUri.toString().contains(".mp4")) {
//                FirebaseStorage.getInstance().getReference("influencerVideo")
//                    .child(FirebaseAuth.getInstance().currentUser!!.uid)
//                    .child(uuid).putFile(imgUri).addOnSuccessListener {
//                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
//                    }
//            } else {
//                FirebaseStorage.getInstance().getReference("influencerImage")
//                    .child(FirebaseAuth.getInstance().currentUser!!.uid)
//                    .child(uuid).putFile(imgUri).addOnSuccessListener {
//                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
//
//                    }
//
//            }
//        }
//    }
//


}










