package jobs

import io.ioSchema.StackExchangeInputSchema
import org.apache.hadoop.fs.Path
import modeller.{PostsModeller, UserModeller}
import org.apache.spark.sql.Dataset

trait JobsMediator {
  def userModelProcessors(path: String)= {

    UserModeller

  }
}
