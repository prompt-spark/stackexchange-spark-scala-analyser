package modeller

import io.UsersXmlDataLoader
import org.apache.hadoop.fs.Path

object userPostsHistoryModeller {

  def userPostHistory(path: Path) = {
    UsersXmlDataLoader.main(path.toString)
  }
}
