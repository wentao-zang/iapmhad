<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="name">
      <el-input v-model="dataForm.name" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="նܢޠ+" prop="dis">
      <el-input v-model="dataForm.dis" placeholder="նܢޠ+"></el-input>
    </el-form-item>
    <el-form-item label="Ӥֈ܆ӵʼցʽ" prop="oridata">
      <el-input v-model="dataForm.oridata" placeholder="Ӥֈ܆ӵʼցʽ"></el-input>
    </el-form-item>
    <el-form-item label="" prop="v3data">
      <el-input v-model="dataForm.v3data" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="նޟֱ޶" prop="diameter">
      <el-input v-model="dataForm.diameter" placeholder="նޟֱ޶"></el-input>
    </el-form-item>
    <el-form-item label="նޟȐӤ" prop="length">
      <el-input v-model="dataForm.length" placeholder="նޟȐӤ"></el-input>
    </el-form-item>
    <el-form-item label="նߢλփ" prop="pos">
      <el-input v-model="dataForm.pos" placeholder="նߢλփ"></el-input>
    </el-form-item>
    <el-form-item label="նޟʙü" prop="live">
      <el-input v-model="dataForm.live" placeholder="նޟʙü"></el-input>
    </el-form-item>
    <el-form-item label="" prop="time">
      <el-input v-model="dataForm.time" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          name: '',
          dis: '',
          oridata: '',
          v3data: '',
          diameter: '',
          length: '',
          pos: '',
          live: '',
          time: ''
        },
        dataRule: {
          name: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          dis: [
            { required: true, message: 'նܢޠ+不能为空', trigger: 'blur' }
          ],
          oridata: [
            { required: true, message: 'Ӥֈ܆ӵʼցʽ不能为空', trigger: 'blur' }
          ],
          v3data: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          diameter: [
            { required: true, message: 'նޟֱ޶不能为空', trigger: 'blur' }
          ],
          length: [
            { required: true, message: 'նޟȐӤ不能为空', trigger: 'blur' }
          ],
          pos: [
            { required: true, message: 'նߢλփ不能为空', trigger: 'blur' }
          ],
          live: [
            { required: true, message: 'նޟʙü不能为空', trigger: 'blur' }
          ],
          time: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/drilltool/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.drilltool.name
                this.dataForm.dis = data.drilltool.dis
                this.dataForm.oridata = data.drilltool.oridata
                this.dataForm.v3data = data.drilltool.v3data
                this.dataForm.diameter = data.drilltool.diameter
                this.dataForm.length = data.drilltool.length
                this.dataForm.pos = data.drilltool.pos
                this.dataForm.live = data.drilltool.live
                this.dataForm.time = data.drilltool.time
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/drilltool/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'dis': this.dataForm.dis,
                'oridata': this.dataForm.oridata,
                'v3data': this.dataForm.v3data,
                'diameter': this.dataForm.diameter,
                'length': this.dataForm.length,
                'pos': this.dataForm.pos,
                'live': this.dataForm.live,
                'time': this.dataForm.time
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
