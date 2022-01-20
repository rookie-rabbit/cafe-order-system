package org.cos.practice.entity

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import lombok.*
import net.bytebuddy.description.method.MethodDescription
import net.bytebuddy.description.type.TypeDescription
import javax.persistence.*

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "FAVORITE")
data class FavoriteEntity(
    @Id
    @Column(name = "user_email")
    val userEmail: String = "",

    @Column(name = "product_id_list")
    @Convert(converter = MutableListConverter::class)
    //@ElementCollection
    var productIdList: MutableList<String> = mutableListOf()
){}


class MutableListConverter() : AttributeConverter<MutableList<String>, String>{
    val objectMapper : ObjectMapper = ObjectMapper()

    override fun convertToDatabaseColumn(attribute: MutableList<String>?): String {
        try{
            if(attribute == null)
                return ""
            else
                return "[${attribute.joinToString(",")}]"
        }catch(ex: JsonProcessingException){
            //로그 출력
            throw RuntimeException(ex)
        }
    }

    override fun convertToEntityAttribute(dbData: String?): MutableList<String> {
        try{
            if(dbData != null){
                if(dbData.contains('[') && dbData.contains(']')){
                    val newData : String = dbData.replace("[", "").replace("]", "").replace(" ","")
                    if(newData.isNullOrEmpty())
                        return mutableListOf()
                    else
                        return newData.split(",").toMutableList()
                }else
                    return mutableListOf()
            }else
                return mutableListOf()
        }catch (ex: Exception){
            throw ex;
        }

    }

}