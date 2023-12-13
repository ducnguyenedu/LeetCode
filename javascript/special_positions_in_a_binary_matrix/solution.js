/**
 * @param {number[][]} mat
 * @return {number}
 */
function numSpecial(mat) {
    let res = 0;
    const m = mat.length;
    const n = mat[0].length;

    for (let row = 0; row < m; row++) {
        for (let col = 0; col < n; col++) {
            if (mat[row][col] === 0) {
                continue;
            }
            let good = true;
            for (let r = 0; r < m; r++) {
                if (r !== row && mat[r][col] === 1) {
                    good = false;
                    break;
                }
            }
            for (let c = 0; c < n; c++) {
                if (c !== col && mat[row][c] === 1) {
                    good = false;
                    break;
                }
            }
            if (good) {
                res++;
            }
        }
    }

    return res;
}
