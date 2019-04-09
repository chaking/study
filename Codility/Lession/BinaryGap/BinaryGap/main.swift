//
//  main.swift
//  BinaryGap
//
//  Created by Yeongmin Cha on 22/11/2016.
//  Copyright © 2016 Yeongmin Cha. All rights reserved.
//

import Foundation

let binaryInputValues = [561892, 9, 529, 20, 15]
//let binaryInputValues = [9]

binaryInputValues.forEach { n in
  let result = solution(n)
  print(n, result)
}
