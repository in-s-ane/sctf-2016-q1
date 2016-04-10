import Data.Ord (comparing)
import Data.List (maximumBy, subsequences, nub)

isSorted xs = and $ zipWith (<=) xs (tail xs)

lis :: Ord a => [a] -> [a]
lis = maximumBy (comparing length) . map nub . filter isSorted . subsequences

main = do
    s <- readFile "schensted.dat"
    putStrLn. show . length . lis $ s

-- Could be made a lot faster if patience sorting is used

-- $ ghc -O3 -rtsopts solution.hs
-- $ ./solution +RTS -K8G
-- sctf{224619}
