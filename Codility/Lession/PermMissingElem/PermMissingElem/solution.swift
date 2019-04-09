//
//  solution.swift
//  PermMissingElem
//
//  Created by Yeongmin Cha on 06/12/2016.
//  Copyright © 2016 Yeongmin Cha. All rights reserved.
//

import Foundation

public func solution(_ A: inout [Int]) -> Int{
  let length = A.count
  let rest = length % 2 == 0 ? length / 2 + 1 : 0
  let goal = (length + 2) * (length / 2) + rest
  let sum = A.reduce(0, +)
  return goal - sum
}
