namespace * $package$.models

struct ThriftFile {
  1: string id // ObjectId
  2: i64 length // file size
  3: string md5 // file md5
  4: string filename // file name
  5: string contentType //file type
  6: i64 uploadDate // upload date
}

struct Error {
  1: string msg
}
