class Solution {

    class DisjointSet {

        private var parent: [Int]
        private var rank: [Int]

        init(_ size: Int) {
            self.parent = Array(0..<size)
            self.rank = Array(repeating: 1, count: size)
        }

        func find(_ i: Int) -> Int {
            if parent[i] == i {
                return i
            } else {
                let xi = find(parent[i])

                // Path compression
                parent[i] = xi

                return xi
            }
        }

        func union(_ x: Int, _ y: Int) {
            let xi = find(x)
            let yi = find(y)

            if xi == yi {
                return
            }

			// Rank optimisation
            if rank[xi] < rank[yi] {
                parent[xi] = yi
            } else if rank[yi] < rank[xi] {
                parent[yi] = xi
            } else {
                parent[xi] = yi
                rank[yi] += 1
            }
        }
    }

    func convert(_ char: Character) -> Int {
        let a = Character("a")
        return Int(char.asciiValue! - a.asciiValue!)
    }

    func equationsPossible(_ equations: [String]) -> Bool {

        let ds = DisjointSet(26)

        var notEqual = [(Int, Int)]()

        for eq in equations {
            let eq = Array(eq)
            if eq[1] == "=" {
                ds.union(convert(eq[0]), convert(eq[3]))
            } else {
                notEqual.append((convert(eq[0]), convert(eq[3])))
            }
        }

        for neq in notEqual {
            if ds.find(neq.0) == ds.find(neq.1) {
                return false
            }
        }

        return true
    }

}