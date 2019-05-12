package modeller

import io.ioSchema.StackExchangeInputSchema
import io.loader.UsersXmlDataLoader
import org.apache.spark.sql.Dataset

object UserPostsHistoryModeller {

  def userPostHistory(path: String): Dataset[StackExchangeInputSchema.UsersData] = {

    val userData = UsersXmlDataLoader.loadUsersDS(path.toString)

    userData

  }
}
