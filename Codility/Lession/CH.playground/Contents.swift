//: Playground - noun: a place where people can play

import Cocoa

var str = "Hello, playground"

let a = 3
var b = 4

b = 3

let c = [1, 2, 3]


let e = c.reduce(0) { (sum, value) -> Int in
  return sum + value
}
let f = c.reduce(0) { $0 + $1 }
let g = c.reduce(0) { sum, value in
  sum + value
}
let d = c.reduce(0, -)
print(d, e, g)