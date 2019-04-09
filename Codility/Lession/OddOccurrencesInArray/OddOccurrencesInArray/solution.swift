//
//  solution.swift
//  OddOccurrencesInArray
//
//  Created by Yeongmin Cha on 22/11/2016.
//  Copyright © 2016 Yeongmin Cha. All rights reserved.
//

import Foundation

public func solution(_ A: inout [Int]) -> Int{
  let result = A.reduce(0) { xor, value in
    xor ^ value
  }
  return result
}
