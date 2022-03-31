# Description

Demonstration and test repo for CLJ-2701, supporting the read and write of serialized Keyword and ArraySeq objects across Clojure versions.

# Demo

This will write a serialized Keyword to keyword.ser and write a serialized ArraySeq to arrayseq.ser using Clojure 1.10.3 classes.

```
clj -X:test vwrite :v '"1.10.3"'
```

This will attempt to read these files back using Clojure 1.11.0 classes:

```
clj -X:test vread :v '"1.11.0"'
```

which will fail.

Test a fixed version with something like:

```
clj -X:test vread :v '"1.11.1"'
```

