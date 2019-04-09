//
//  solution.swift
//  CyclicRotation
//
//  Created by Yeongmin Cha on 05/12/2016.
//  Copyright © 2016 Yeongmin Cha. All rights reserved.
//

import Foundation

public func solution(_ A: inout [Int], _ K: Int) -> [Int]{
  var result = A
  guard A.count > 0 else {
    return result
  }
  let k = K % A.count
  for index in 0..<A.count{
    let sourceIndex = k > index ? index + A.count - k : index - k
    result[index] = A[sourceIndex]
  }
  return result
}
