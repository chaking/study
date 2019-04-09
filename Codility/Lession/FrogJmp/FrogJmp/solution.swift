//
//  solution.swift
//  FrogJmp
//
//  Created by Yeongmin Cha on 06/12/2016.
//  Copyright © 2016 Yeongmin Cha. All rights reserved.
//

import Foundation

public func solution(_ X: Int, _ Y: Int, _ D: Int) -> Int{
  let goal = Y - X
  let reminder = goal%D == 0 ? 0 : 1
  let result = goal/D + reminder
  return result
}
