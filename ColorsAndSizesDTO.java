package com.msr.oms.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.msr.product.dto.ColorsDTO;
import com.msr.product.dto.SizesDTO;

/**
 * The Class ColorsAndSizesDTO.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ColorsAndSizesDTO {

	/** The colors DTO. */
	private List<ColorsDTO> colorsDTO;

	/** The sizes DTO. */
	private List<SizesDTO> sizesDTO;

	/**
	 * @return the colorsDTO
	 */
	public List<ColorsDTO> getColorsDTO() {
		return colorsDTO;
	}

	/**
	 * @param colorsDTO the colorsDTO to set
	 */
	public void setColorsDTO(List<ColorsDTO> colorsDTO) {
		this.colorsDTO = colorsDTO;
	}

	/**
	 * @return the sizesDTO
	 */
	public List<SizesDTO> getSizesDTO() {
		return sizesDTO;
	}

	/**
	 * @param sizesDTO the sizesDTO to set
	 */
	public void setSizesDTO(List<SizesDTO> sizesDTO) {
		this.sizesDTO = sizesDTO;
	}
}
