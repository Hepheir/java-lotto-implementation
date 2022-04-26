package domain;

import java.util.Collection;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

public class LottoWinningStatSequence extends TreeSet<LottoWinningStat> implements SortedSet<LottoWinningStat> {
    @Override
    public boolean add(LottoWinningStat newStat) {
        Optional<LottoWinningStat> oldStat = findEquals(newStat);
        if (oldStat.isPresent()) {
            updateOldStat(oldStat.get(), newStat);
            return true;
        }
        addNewStat(newStat);
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends LottoWinningStat> c) {
        for (LottoWinningStat lottoWinningStat : c) {
            add(lottoWinningStat);
        }
        return true;
    }

    private void updateOldStat(LottoWinningStat oldStat, LottoWinningStat newStat) {
        oldStat.merge(newStat);
    }

    private void addNewStat(LottoWinningStat newStat) {
        super.add(newStat);
    }

    private Optional<LottoWinningStat> findEquals(LottoWinningStat stat) {
        return this.stream()
                .filter(stat::equals)
                .findAny();
    }
}
