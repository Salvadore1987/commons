package uz.salvadore.datagrid.library;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import uz.salvadore.datagrid.library.dto.DataGridRequest;
import uz.salvadore.datagrid.library.dto.DataGridResponse;

public interface GridService {

  <I, O> DataGridResponse<O> grid(DataGridRequest request, IDataGridMapper<I, O> mapper, JpaSpecificationExecutor<I> repository);

}
