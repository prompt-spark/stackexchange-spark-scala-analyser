package jobs

import org.apache.hadoop.fs.Path
import modeller.userPostsHistoryModeller

trait JobsMediator {
  def userProcessors(path: Path) = {

    userPostsHistoryModeller.userPostHistory(path)

  }
}
