package com.ardidong.ticketingapp.data.core.destination

import com.ardidong.ticketingapp.data.core.destination.model.DestinationFirebaseResponse
import com.ardidong.ticketingapp.domain.common.ErrorEntity
import com.ardidong.ticketingapp.domain.common.ResultOf
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class GetDestinationRemoteSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : GetDestinationRemoteSource {
    override suspend fun invoke(): ResultOf<List<DestinationFirebaseResponse>> = suspendCoroutine { continuation ->
        firestore.collectionGroup("destinations").limit(10).get()
            .addOnSuccessListener {result ->

                val list = mutableListOf<DestinationFirebaseResponse>()
                result.documents.forEach {
                    it.toObject(DestinationFirebaseResponse::class.java)?.let { response ->
                        list.add(response)
                    }
                }

                continuation.resume(ResultOf.Success(list))
            }
            .addOnFailureListener {
                it.printStackTrace()
                continuation.resume(ResultOf.Failure(ErrorEntity.RequestFailedError(it.localizedMessage.orEmpty())))
            }

    }
//
//    val groupRefDoc = firestore.collection("group").document("Naaxg9poSWC6CQj3w8S9")
//        .collection("destinations")
//
//    destinationList.forEach {
//        val destinationDocRef = groupRefDoc.document(it.destinationId.toString())
//        batch.set(destinationDocRef, it)
//    }
//
//    batch.commit()
//    .addOnSuccessListener {
//        Log.w("EHE", "success")
//    }
//    .addOnFailureListener {
//        Log.e("EHE", it.localizedMessage)
//        it.printStackTrace()
//    }
//
//    val destinationList = listOf(
//        DestinationFirebaseResponse(
//            destinationId = 1,
//            destinationName = "Candi Prambanan",
//            destinationDescription = "Prambanan is a 9th-century Hindu temple compound in the Special Region of Yogyakarta, in southern Java, Indonesia...",
//            destinationAddress = "Jl. Raya Solo - Yogyakarta No.16, Kranggan, Bokoharjo, Kec. Prambanan, Kabupaten Sleman, Daerah Istimewa Yogyakarta",
//            destinationImageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Prambanan_Temple_Yogyakarta_Indonesia.jpg/1920px-Prambanan_Temple_Yogyakarta_Indonesia.jpg",
//            destinationOpen = "06.30",
//            destinationClose = "17.00",
//            latitude = -7.7520206,
//            longitude = 110.4914674,
//            tag = listOf("heritage", "temple", "history")
//        ),
//        DestinationFirebaseResponse(
//            destinationId = 2,
//            destinationName = "Taman Sari",
//            destinationDescription = "Taman Sari Water Castle, also known as Taman Sari (Javanese: ꦠꦩꦤ꧀ ꦱꦫꦶ), is the site of a former royal garden of the Sultanate of Yogyakarta...",
//            destinationAddress = "Patehan, Kraton, Yogyakarta City, Special Region of Yogyakarta",
//            destinationImageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/07/Indonesia_-_Java_-_Yogyakarta_-_Taman_Sari.jpg/1920px-Indonesia_-_Java_-_Yogyakarta_-_Taman_Sari.jpg",
//            destinationOpen = "09.00",
//            destinationClose = "15.00",
//            latitude = -7.8100673,
//            longitude = 110.3594581,
//            tag = listOf("heritage", "history")
//        ),
//        DestinationFirebaseResponse(
//            destinationId = 3,
//            destinationName = "Gembira Loka Zoo",
//            destinationDescription = "Gembira Loka is a zoological garden located in Yogyakarta, Special Region of Yogyakarta, Indonesia. Gembira Loka Zoo was opened in 1956...",
//            destinationAddress = "Jl. Kebun Raya No.2 Kelurahan Rejowinangun, Kotagede, Kota Yogyakarta, Daerah Istimewa Yogyakarta",
//            destinationImageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Gembira_Loka_Zoo_in_Yogyakarta.jpg/1280px-Gembira_Loka_Zoo_in_Yogyakarta.jpg",
//            destinationOpen = "08.00",
//            destinationClose = "16.00",
//            latitude = -7.8060038,
//            longitude = 110.3936758,
//            tag = listOf("zoo", "family")
//        ),
//        DestinationFirebaseResponse(
//            destinationId = 4,
//            destinationName = "Candi Ratu Boko",
//            destinationDescription = "Ratu Boko or Ratu Boko Palace is an archaeological site in Java. Ratu Boko is located on a plateau, about three kilometres south of Prambanan temple complex in Yogyakarta, Indonesia",
//            destinationAddress = "Jl. Raya Piyungan - Prambanan No.2, Gatak, Bokoharjo, Kec. Prambanan, Kabupaten Sleman, Daerah Istimewa Yogyakarta",
//            destinationImageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Kraton_Ratu_Boko_%28Ratu_Boko_Temple%29_in_Yogyakarta%2C_Indonesia_03.jpg/300px-Kraton_Ratu_Boko_%28Ratu_Boko_Temple%29_in_Yogyakarta%2C_Indonesia_03.jpg",
//            destinationOpen = "08.00",
//            destinationClose = "17.00",
//            latitude = -7.7704677,
//            longitude = 110.4826263,
//            tag = listOf("history", "heritage", "temple")
//        )
//    )
}