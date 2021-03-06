(ns beginner_guide.section2.CarCouponChallenge)

(def cars {"bmw" 60000 "ferrari" 100000 "fiat" 20000})

(defn isCodeValid
  [code]
  (defrecord coupon  [Name Discount])
  (def validCoupon (struct coupon "20Percent" 0.8))
  (if (= (:Name validCoupon) code)
    true
    false))

(defn getCarPrices
  [budget coupon]


  (if (isCodeValid coupon)
    (do (println "The code is valid")
        (def discount (:Discount validCoupon))
        (doseq [car cars]
          (def carType (first car))
          (def price (last car))
          (def priceDiscount (* price discount))
          (if (<= priceDiscount budget)
            (println "The" carType "costs" priceDiscount))))
    (do (println "The code is invalid")
        (doseq [car cars]
          (def carType (first car))
          (def price (last car))
          (if (<= price budget)
            (println "The" carType "costs" price))))))

(getCarPrices 50000 "20Percents")