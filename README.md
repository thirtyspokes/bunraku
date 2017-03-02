# bunraku

A Clojure interface to Selenium Webdriver.  A work in progress.

## Usage

Create a new driver:

```clojure
(def chrome (chrome-driver))
```

Now, all of the browser interaction functions return a map that has two keys, one for the driver object itself (:driver) and one for the most recently selected DOM element.  This allows you to thread your interactions together:

```clojure
(defn search-for-vaporwave
  [driver]
  (-> driver
    (get-url "https://youtube.com")
    (find-element-by-css "#masthead-search-term")
    (send-text "vaporwave")
    submit-form
    (find-element-by-css "#results .item-section li:nth-child")
    click))
```

This might not be a great design.

## License

Copyright © 2016 Ray Ashman Jr.

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
