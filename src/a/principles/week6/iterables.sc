val x = Array(1, 2, 3)
x map (_ * 2)

val s = "Hello World"
s filter (_.isUpper)

s exists (_.isUpper)
s forall (_.isUpper)

val pairs = List(1, 2, 3, 4) zip s
pairs unzip

s flatMap (List('.', _))

x.sum
x.max

