package com.mishalpandey.docss.development

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fitnytech.influencerApp.development.databinding.ImageviewerBinding
import kotlin.collections.ArrayList

class Adapter(var context: Context, var list: ArrayList<String>, var button4Uploading: Button):RecyclerView.Adapter<Adapter.ViewHolder>() {
    val IMAGE_CODE = 0
    val VIDEO_CODE = 1

    var selectedList = arrayListOf<String>()

    class ViewHolder(var binding: ImageviewerBinding):RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       var view = ImageviewerBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     //   holder.binding.button.visibility = View.GONE

      Glide.with(context).load(list[position]).into(holder.binding.imageView)
        if (!list[position].contains(".mp4")){
            holder.binding.button.visibility = View.GONE
        }

        holder.binding.button4Selection.visibility = View.GONE




        holder.itemView.setOnClickListener {
            // Toggle checkbox state
            val item = list[position]
            // Set checkbox state based on whether item is selected
            if (holder.binding.button4Selection.visibility == View.GONE) {
                // Add item to selected list
                //Toast.makeText(context, "Yes added", Toast.LENGTH_SHORT).show()
                selectedList.add(item)
                //Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                holder.binding.button4Selection.visibility = View.VISIBLE
               // Toast.makeText(context, "$selectedList.size", Toast.LENGTH_SHORT).show()
            } else {
                // Remove item from selected list
                selectedList.remove(item)
                holder.binding.button4Selection.visibility = View.GONE
                //Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                //Toast.makeText(context, "Yes removed", Toast.LENGTH_SHORT).show()
                //Toast.makeText(context, "$selectedList.size", Toast.LENGTH_SHORT).show()

            }

        }

        button4Uploading.setOnClickListener{
            //Toast.makeText(context, "good track", Toast.LENGTH_SHORT).show()
            //Toast.makeText(context, "$selectedList.size", Toast.LENGTH_SHORT).show()
            val imageExtensions = listOf("jpg", "jpeg", "png", "gif", "bmp")
            val videoExtensions = listOf("mp4", "3gp", "mkv", "avi")

//            for (path in selectedList) {
//                // Upload image to Firebase
//                val fileExtension = path.substringAfterLast(".")
//                var uuid = UUID.randomUUID().toString()
//                if (imageExtensions.contains(fileExtension.toLowerCase())) {
//
//                    val file = File(path)
//                    val storageRef = FirebaseStorage.getInstance().getReference("influencerImage").child(
//                        FirebaseAuth.getInstance().currentUser!!.uid).child(uuid)
//                    val uploadTask = storageRef.putFile(Uri.fromFile(file))
//
//                    // Handle upload success or failure
//                    uploadTask.addOnSuccessListener {
//                        // Image uploaded successfully
//
//                    }.addOnFailureListener {
//                        // Image upload failed
//                    }
//                }
//                else if(videoExtensions.contains(fileExtension.toLowerCase())){
//
//                    val file = File(path)
//
//                    val storageRef = FirebaseStorage.getInstance().getReference("influencerVideo").child(
//                        FirebaseAuth.getInstance().currentUser!!.uid).child(uuid)
//                    val uploadTask = storageRef.putFile(Uri.fromFile(file))
//
//                    // Handle upload success or failure
//                    uploadTask.addOnSuccessListener {
//                        // Image uploaded successfully
//                    }.addOnFailureListener {
//                        // Image upload failed
//                    }
//                }
//                else{
//                    Toast.makeText(context, "Select only Images and videos ", Toast.LENGTH_SHORT).show()
//
//                }
//            }

            Toast.makeText(context, "Uploaded Successfully", Toast.LENGTH_SHORT).show()



    }






    }

    override fun getItemCount(): Int {
      return  list.size
    }



}