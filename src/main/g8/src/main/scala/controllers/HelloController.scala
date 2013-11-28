package $package$.controllers

import $package$.models.HelloModel

object HelloController {
  def say(word: String) = {
    HelloModel.say(word: String).toString
  }
}
