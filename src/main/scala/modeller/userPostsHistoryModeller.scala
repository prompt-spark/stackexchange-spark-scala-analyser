package modeller

import io.loader.UsersXmlDataLoader
import org.apache.hadoop.fs.Path

object userPostsHistoryModeller {

  def userPostHistory(path: Path) = {
    UsersXmlDataLoader.loadUsersDS(path.toString)
  }
}
