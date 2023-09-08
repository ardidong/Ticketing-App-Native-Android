package com.ardidong.ticketingapp.data.core.group

import com.ardidong.ticketingapp.data.core.group.mapper.GroupMapper
import com.ardidong.ticketingapp.data.core.group.model.GroupFirebaseResponse
import com.ardidong.ticketingapp.domain.common.ErrorEntity
import com.ardidong.ticketingapp.domain.common.PathKey
import com.ardidong.ticketingapp.domain.common.ResultOf
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class GroupRemoteSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
) : GroupRemoteSource {
    private val mapper = GroupMapper()
    override suspend fun invoke(): ResultOf<List<GroupFirebaseResponse>> = suspendCoroutine{ continuation ->
        firestore.collection(PathKey.GROUP)
            .get()
            .addOnSuccessListener { result ->
                val list = mutableListOf<GroupFirebaseResponse>()
                result.documents.forEach { document ->
                    list.add(mapper.toResponse(document))
                }

                continuation.resume(ResultOf.Success(list))
            }
            .addOnFailureListener {
                it.printStackTrace()
                continuation.resume(ResultOf.Failure(ErrorEntity.RequestFailedError(it.localizedMessage.orEmpty())))
            }
    }

//    val groupList = listOf(
//        GroupFirebaseResponse(
//            groupName = "Jawa Tengah",
//            groupAddress = "Jawa Tengah, Indonesia",
//            groupDescription = "Central Java is a province on the Indonesian island of Java, with a strong Buddhist and Hindu heritage...",
//            groupImageUrl = "https://awsimages.detik.net.id/community/media/visual/2022/06/05/ilustrasi-candi-borobudur_43.jpeg?w=600&q=90"
//        ),
//        GroupFirebaseResponse(
//            groupName = "Jakarta",
//            groupAddress = "Daerah Khusus Ibukota Jakarta, Indonesia",
//            groupDescription = "Jakarta, Indonesia's massive capital, sits on the northwest coast of the island of Java...",
//            groupImageUrl = "https://www.nationsonline.org/gallery/Indonesia/Jakarta-Skyline-from-Bund.jpg"
//        ),
//        GroupFirebaseResponse(
//            groupName = "Bali",
//            groupAddress = "Bali, Indonesia",
//            groupDescription = "Bali is a province of Indonesia and the westernmost of the Lesser Sunda Islands...",
//            groupImageUrl = "https://a.cdn-hotels.com/gdcs/production143/d1112/c4fedab1-4041-4db5-9245-97439472cf2c.jpg"
//        ),
//        GroupFirebaseResponse(
//            groupName = "Jawa Timur",
//            groupAddress = "Jawa Timur, Indonesia",
//            groupDescription = "East Java, the rugged Indonesian province, includes the eastern part of Java plus Madura and some smaller islands...",
//            groupImageUrl = "https://ik.imagekit.io/tvlk/blog/2022/09/Wisata-Gunung-Bromo-Traveloka-Xperience-1.jpg?tr=dpr-2,w-675"
//        ),
//        GroupFirebaseResponse(
//            groupName = "Yogyakarta",
//            groupAddress = "Daerah Istimewa Yogyakarta",
//            groupDescription = "Yogyakarta is a central region on the Indonesian island of Java. Its capital, also called Yogyakarta, is a cultural hub known for its traditional crafts and performing arts. The city is home to the 18th-century royal complex, or kraton, known for its still-inhabited Sultan’s Palace as well as open-air pavilions that host events like gamelan concerts and Javanese dance performances.",
//            groupImageUrl = "https://upload.wikimedia.org/wikipedia/commons/9/98/Prambanan_Trimurti.jpg"
//        )
//    )

}

