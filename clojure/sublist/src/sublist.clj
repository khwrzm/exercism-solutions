(ns sublist)

#_(defn remove-first-n
  [l n]
  (loop [rem l cnt 0]
    (if (= cnt n)
      rem
      (recur (rest rem) (inc cnt)))))

#_(defn is-sublist
  [a b]
  (loop [remA a remB b cnt 0]
    (if (> (count remA) (count remB))
      false
      (if (empty? remA)
        true
        (if (= (first remA) (first remB))
          (recur (rest remA) (rest remB) cnt)
          (recur a (remove-first-n b (inc cnt)) (inc cnt)))))))

#_(defn classify [list1 list2] ;; <- arglist goes here
     ;; your code goes here
  (if (= (count list1) (count list2))
    (if (= list1 list2)
      :equal
      :unequal)
    (if (> (count list1) (count list2))
      (if (is-sublist list2 list1)
        :superlist
        :unequal)
      (if (is-sublist list1 list2)
        :sublist
        :unequal))))

;; Better soltuion


;; Best solution
(defn sublist? [coll1 coll2]
  (some #{coll1} (partition (count coll1) 1 coll2)))
(defn classify [coll1 coll2]
  (cond (= coll1 coll2) :equal
        (sublist? coll1 coll2) :sublist
        (sublist? coll2 coll1) :superlist
        :else :unequal))
