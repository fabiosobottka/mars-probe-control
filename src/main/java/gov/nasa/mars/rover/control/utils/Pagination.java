
package gov.nasa.mars.rover.control.utils;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Pagination<T> implements Serializable {

	private static final long serialVersionUID = -176010561340354273L;

	private final long pageNumber;

	private final long pageSize;

	private final long totalElements;

	private final long totalPages;

	private final List<T> content;

	public Pagination() {
		this(Collections.emptyList());
	}

	public Pagination(final List<T> list) {
		this(list, 0, list == null ? 0 : list.size(), list == null ? 0 : list.size());
	}

	public Pagination(final List<T> list, final long page, final long size, final long total) {
		this.pageNumber = page;
		this.pageSize = size;
		this.content = list == null ? Collections.emptyList() : list;

		this.totalElements = calculateTotalElements(total);
		this.totalPages = calculateTotalPages();
	}

	private long calculateTotalElements(final long total) {
		final long offset = pageNumber * pageSize;
		return offset + pageSize > total ? offset + content.size() : total;
	}

	private long calculateTotalPages() {
		return pageSize == 0 ? 1 : (int) Math.ceil((double) totalElements / (double) pageSize);
	}

	public List<T> getContent() {
		return Collections.unmodifiableList(content);
	}

	private <E> List<E> getConvertedContent(final Function<? super T, ? extends E> converter) {
		return content.stream().map(converter::apply).collect(Collectors.toList());
	}

	public long getPageNumber() {
		return pageNumber;
	}

	public long getPageSize() {
		return pageSize;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public <E> Pagination<E> map(final Function<? super T, ? extends E> converter) {
		return new Pagination<>(getConvertedContent(converter), pageNumber, pageSize, totalElements);
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, pageNumber, pageSize, totalElements, totalPages);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagination other = (Pagination) obj;
		return Objects.equals(content, other.content) && pageNumber == other.pageNumber && pageSize == other.pageSize
				&& totalElements == other.totalElements && totalPages == other.totalPages;
	}

	@Override
	public String toString() {
		return "Pagination [pageNumber=" + pageNumber + ", pageSize=" + pageSize + ", totalElements=" + totalElements
				+ ", totalPages=" + totalPages + ", content=" + content + "]";
	}

}
