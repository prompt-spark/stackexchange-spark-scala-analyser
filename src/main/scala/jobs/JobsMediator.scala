package jobs

import io.ioSchema.StackExchangeInputSchema
import org.apache.hadoop.fs.Path
import modeller.UserPostsHistoryModeller
import org.apache.spark.sql.Dataset

trait JobsMediator {
  def userProcessors(path: String): Dataset[StackExchangeInputSchema.UsersData] = {

    UserPostsHistoryModeller.userPostHistory(path)

  }
}
